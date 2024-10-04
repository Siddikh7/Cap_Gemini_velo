

--
-- Table structure for table `utilisateur`
--

CREATE TABLE `utilisateur` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `prenom` varchar(100) NOT NULL,
  `mail` varchar(100) NOT NULL,
  `password` varchar(100) NOT NULL,
  `username` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Table structure for table `velo`
--

CREATE TABLE `velo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nom` varchar(100) NOT NULL,
  `quantite` int(11) NOT NULL,
  `description` varchar(100) DEFAULT NULL,
  `point_geo` varchar(100) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=38 DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `utilisateur_id` int(11) NOT NULL,
  `velo_id` int(11) NOT NULL,
  `reservation` int(11) NOT NULL,
  PRIMARY KEY (`utilisateur_id`,`velo_id`),
  KEY `velo_id` (`velo_id`),
  CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`id`),
  CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`velo_id`) REFERENCES `velo` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb3 COLLATE=utf8mb3_general_ci;
