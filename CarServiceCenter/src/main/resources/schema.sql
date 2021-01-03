CREATE TABLE IF NOT EXISTS `appointment` (
  `id` INTEGER PRIMARY KEY AUTO_INCREMENT,
  `car` text DEFAULT NULL,
  `plate_num` text DEFAULT NULL,
  `customer_name` text DEFAULT NULL,
  `customer_phone` text DEFAULT NULL,
  `appt_description` text DEFAULT NULL,
  `status` text DEFAULT 'incomplete',
  `price` float DEFAULT NULL,
  `date_created` timestamp NOT NULL DEFAULT current_timestamp() 
);