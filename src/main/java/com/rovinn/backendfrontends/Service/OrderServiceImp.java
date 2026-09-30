    package com.rovinn.backendfrontends.Service;
    import com.rovinn.backendfrontends.Repository.OrderRepository;
    import com.rovinn.backendfrontends.Repository.ProductRepository;
    import com.rovinn.backendfrontends.Repository.UserRepository;
    import com.rovinn.backendfrontends.model.*;
    import org.springframework.stereotype.Service;

    import java.time.LocalDateTime;
    import java.util.ArrayList;
    import java.util.List;
    import java.util.stream.Collectors;

    @Service
    public class OrderServiceImp implements OrderServiceInterface {
        private final UserRepository userRepository;
        private final OrderRepository orderRepository;
        private final ProductRepository productRepository;
        public OrderServiceImp(ProductRepository productRepository,OrderRepository orderRepository,UserRepository userRepository) {
            this.userRepository = userRepository;
            this.orderRepository = orderRepository;
            this.productRepository = productRepository;
        }
        @Override
        public OrderResponseDTO createOrder(OrderRequestDTO orderRequestDTO,String userEmail){
            User user = userRepository.findByEmail(userEmail).
                    orElseThrow(
                                 ()-> new RuntimeException("User not found"));
            Order order = new Order();
            order.setUser(user);
            order.setOrderStatus(OrderStatus.PENDING);
            order.setCreatedAt(LocalDateTime.now());
            order.setPaymentMethod(orderRequestDTO.getPaymentMethod());

            List<OrderItem> orderItems = new ArrayList<>();
            for (OrderItemRequestDTO itemRequestDTO : orderRequestDTO.getOrderItems()) {
                OrderItem orderItem = new OrderItem();
                 Product product = productRepository.
                         findById(itemRequestDTO.getProductId()).orElseThrow(
                                 ()-> new RuntimeException("Product not found"));
                 orderItem.setOrder(order);
                 orderItem.setProduct(product);
                 orderItem.setQuantity(itemRequestDTO.getQuantity());
                 orderItems.add(orderItem);
            }

            order.setItems(orderItems);
            orderRepository.save(order);

           return mapToOrderResponseDTO(order);
        }

        @Override
        public List<OrderResponseDTO> getAllOrders(){
          return orderRepository.findAll().stream().map(this::mapToOrderResponseDTO).collect(Collectors.toList());
        }
        @Override
        public OrderResponseDTO getOrderById(Long id){
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
            return mapToOrderResponseDTO(order);
        }
        @Override
        public OrderResponseDTO updateStatusById(Long id,  OrderStatus newStatus){
            Order order = orderRepository.findById(id).orElseThrow(() -> new RuntimeException("Order not found"));
            order.setOrderStatus(newStatus);
            orderRepository.save(order);
            return mapToOrderResponseDTO(order);
        }

        private OrderResponseDTO mapToOrderResponseDTO(Order order) {
            List<OrderItemResponseDTO> itemDto = new ArrayList<>();
            for (OrderItem orderItem : order.getItems()) {
                OrderItemResponseDTO orderItemResponseDTO = new OrderItemResponseDTO();
                orderItemResponseDTO.setProductName(orderItem.getProduct().getName());
                orderItemResponseDTO.setQuantity(orderItem.getQuantity());
                itemDto.add(orderItemResponseDTO);
            }
            OrderResponseDTO orderResponseDTO = new OrderResponseDTO();
            orderResponseDTO.setId(order.getId());
            orderResponseDTO.setOrderStatus(order.getOrderStatus());
            orderResponseDTO.setCreateAt(order.getCreatedAt());
            orderResponseDTO.setPaymentMethod(order.getPaymentMethod());
            orderResponseDTO.setOrderItems(itemDto);
            return orderResponseDTO;
     }
    }
