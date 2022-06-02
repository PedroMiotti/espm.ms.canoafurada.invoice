CREATE DATABASE `espm.ms.invoice`

CREATE TABLE `invoice` (
                        `id` char(36) NOT NULL,
                        `id_booking` char(36) NOT NULL,
                        `created_at` DATE NOT NULL,
                        `total` decimal(2,0) NOT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;