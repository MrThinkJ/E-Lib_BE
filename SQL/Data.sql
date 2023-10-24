SELECT * FROM elib.author;

INSERT INTO `elib`.`author` (`author`) VALUES ('Nguyễn Nhật Ánh');
INSERT INTO `elib`.`author` (`author`) VALUES ('Thích Nhất Hạnh');
INSERT INTO `elib`.`author` (`author`) VALUES ('Jose Mauro De Vasconcelos');
INSERT INTO `elib`.`author` (`author`) VALUES ('Minh Niệm');

SELECT * FROM elib.category;

INSERT INTO `elib`.`category` (`id`, `name`) VALUES ('1', 'Tiểu thuyết');
INSERT INTO `elib`.`category` (`id`, `name`) VALUES ('2', 'Truyền cảm hứng');
INSERT INTO `elib`.`category` (`id`, `name`) VALUES ('3', 'Truyện ngắn');
INSERT INTO `elib`.`category` (`id`, `name`) VALUES ('4', 'Cuộc sống');

SELECT * FROM elib.publisher;

INSERT INTO `elib`.`publisher` (`publisher`) VALUES ('Nhà xuất bản trẻ');
INSERT INTO `elib`.`publisher` (`publisher`) VALUES ('Nhà xuất bản thế giới');
INSERT INTO `elib`.`publisher` (`publisher`) VALUES ('Nhà xuất bản hội nhà văn');
INSERT INTO `elib`.`publisher` (`publisher`) VALUES ('Nhà xuất bản tổng hợp thành phố Hồ Chí Minh');

SELECT * FROM elib.roles;

INSERT INTO `elib`.`roles` (`role_name`) VALUES ('ROLE_ADMIN');
INSERT INTO `elib`.`roles` (`role_name`) VALUES ('ROLE_USER');

SELECT * FROM elib.books;

INSERT INTO `elib`.`books` (`id`, `author`, `create_date`, `description`, `price`, `published_year`, `publisher`, `quantity`, `title`) VALUES (1, 'Nguyễn Nhật Ánh', '2023-10-23', 'Ngôn ngữ sâu sắc, thân thiện và gần gũi, dễ lắng nghe câu chuyện', 109000, '2023-10-1', 'Nhà xuất bản trẻ', 10, 'Mùa hè không tên');
INSERT INTO `elib`.`books` (`id`, `author`, `create_date`, `description`, `price`, `published_year`, `publisher`, `quantity`, `title`) VALUES (2, 'Thích Nhất Hạnh', '2023-10-23', 'Sách mang thông điệp về sự tự do và giải thoát khỏi nỗi sợ hãi', 75000, '2023-10-1', 'Nhà xuất bản thế giới', 5, 'Không diệt không sinh đừng sợ hãi');
INSERT INTO `elib`.`books` (`id`, `author`, `create_date`, `description`, `price`, `published_year`, `publisher`, `quantity`, `title`) VALUES (3, 'Jose Mauro De Vasconcelos', '2023-10-23', 'Kể về cuộc đời của tác giả thông qua góc nhìn của chính ông', 108000, '2023-10-1', 'Nhà xuất bản hội nhà văn', 20, 'Cây cam ngọt của tôi');
INSERT INTO `elib`.`books` (`id`, `author`, `create_date`, `description`, `price`, `published_year`, `publisher`, `quantity`, `title`) VALUES (4, 'Minh Niệm', '2023-10-23', 'Khơi gợi niềm hứng thú để hiểu bản thân chính mình', 126000, '2018-10-1', 'Nhà xuất bản tổng hợp thành phố Hồ Chí Minh', 15, 'Hiểu về trái tim');

SELECT * FROM elib.user;

INSERT INTO `elib`.`user` (`id`, `age`, `create_date`, `email`, `gender`, `name`, `password`, `phone`, `role_id`) VALUES ('1', '20', '2023-9-15', 'letranninh@gmail.com', 1, 'Lê Trần Ninh', '280103', '0793577579', '2');
INSERT INTO `elib`.`user` (`id`, `age`, `create_date`, `email`, `gender`, `name`, `password`, `phone`, `role_id`) VALUES ('2', '20', '2023-9-15', 'nguyenngoctruong@gmail.com', 1, 'Nguyễn Ngọc Trường', '159357', '0124578684', '2');
INSERT INTO `elib`.`user` (`id`, `age`, `create_date`, `email`, `gender`, `name`, `password`, `phone`, `role_id`) VALUES ('3', '20', '2023-9-15', 'ledinhthinh@gmail.com', 1, 'Lê Đình Thịnh', '246810', '0975613478', '2');
INSERT INTO `elib`.`user` (`id`, `age`, `create_date`, `email`, `gender`, `name`, `password`, `phone`, `role_id`) VALUES ('4', '20', '2023-9-15', 'mactuongson@gmail.com', 1, 'Mạc Tường Sơn', '147258', '0978435475', '1');
INSERT INTO `elib`.`user` (`id`, `age`, `create_date`, `email`, `gender`, `name`, `password`, `phone`, `role_id`) VALUES ('5', '20', '2023-9-15', 'nguyenvanthang@gmail.com', 1, 'Nguyễn Văn Thắng', '654321', '0784321547', '1');

SELECT * FROM elib.borrow_entity;

INSERT INTO `elib`.`borrow_entity` (`id`, `borrow_date`, `rate`, `return_date`, `book_id`, `user_id`) VALUES ('1', '2023-10-24', 1, '2023-10-29', '1', '1');
INSERT INTO `elib`.`borrow_entity` (`id`, `borrow_date`, `rate`,  `return_date`, `book_id`, `user_id`) VALUES ('2', '2023-10-26', 2, '2023-10-30', '4', '5');
INSERT INTO `elib`.`borrow_entity` (`id`, `borrow_date`, `rate`, `return_date`, `book_id`, `user_id`) VALUES ('3', '2023-10-10', 3,  '2023-10-15', '2', '3');
INSERT INTO `elib`.`borrow_entity` (`id`, `borrow_date`, `rate`, `return_date`, `book_id`, `user_id`) VALUES ('4', '2023-10-23', 4, '2023-10-28', '3', '4');


SELECT * FROM elib.category_book;

INSERT INTO `elib`.`category_book` (`category_id`, `book_id`) VALUES ('1', '1');
INSERT INTO `elib`.`category_book` (`category_id`, `book_id`) VALUES ('2', '2');
INSERT INTO `elib`.`category_book` (`category_id`, `book_id`) VALUES ('3', '3');
INSERT INTO `elib`.`category_book` (`category_id`, `book_id`) VALUES ('4', '4');



