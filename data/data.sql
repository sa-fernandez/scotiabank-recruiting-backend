use test;

INSERT INTO `test`.`Position` (`title`, `salary`) VALUES
('Software Engineer', 60000.00),
('Project Manager', 75000.00),
('Data Analyst', 55000.00),
('UX Designer', 50000.00);

INSERT INTO `test`.`City` (`name`) 
VALUES 
('Bogotá'),
('Medellín'),
('Cali'),
('Barranquilla'),
('Cartagena'),
('Cúcuta'),
('Bucaramanga'),
('Pereira'),
('Santa Marta'),
('Manizales');

INSERT INTO `test`.`Employee` 
(`first_name`, `middle_name`, `last_name`, `address`, `date_birth`, `hire_date`, `email`, `status`, `Position_id`, `City_id`) 
VALUES 
('Nicolas', NULL, 'Pachon', 'Cra 39B # 4 - 20', '14-12-2001', '02-11-2024', 'nicolas.pachon@example.com', 'ACTIVE', 1, 1),
('Santiago', NULL, 'Fernandez', 'Cra 15 # 10 - 15', '22-05-1995', '02-11-2024', 'santiago.fernandez@example.com', 'ACTIVE', 1, 2),
('Kiryu', NULL, 'Kazuma', 'Cra 8 # 7 - 25', '01-04-1986', '02-11-2024', 'kiryu.kazuma@example.com', 'ACTIVE', 1, 3),
('Goro', NULL, 'Majima', 'Cra 23 # 13 - 30', '18-07-1982', '02-11-2024', 'goro.majima@example.com', 'ACTIVE', 1, 4),
('Ichiban', NULL, 'Kasuga', 'Cra 50 # 6 - 15', '01-01-1990', '02-11-2024', 'ichiban.kasuga@example.com', 'ACTIVE', 1, 5);