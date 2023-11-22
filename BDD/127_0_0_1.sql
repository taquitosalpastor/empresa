-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 22-11-2023 a las 02:54:20
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `farmacia`
--
CREATE DATABASE IF NOT EXISTS `farmacia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `farmacia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agcitas`
--
-- Creación: 22-11-2023 a las 01:02:17
--

CREATE TABLE `agcitas` (
  `idCitas` int(11) NOT NULL,
  `NomC` varchar(50) NOT NULL,
  `Fecha` varchar(10) NOT NULL,
  `Direccion` varchar(120) NOT NULL,
  `Sexo` varchar(6) NOT NULL,
  `NumTel` varchar(10) NOT NULL,
  `Sintomas` varchar(200) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agmedicamento`
--
-- Creación: 22-11-2023 a las 01:27:07
--

CREATE TABLE `agmedicamento` (
  `idMedicamento` int(11) NOT NULL,
  `Medicamento` varchar(30) NOT NULL,
  `Provedor` varchar(30) NOT NULL,
  `Tipo` varchar(35) NOT NULL,
  `Stock` int(50) NOT NULL,
  `Precio` int(4) NOT NULL,
  `idProvedor` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agprovedores`
--
-- Creación: 22-11-2023 a las 01:14:31
--

CREATE TABLE `agprovedores` (
  `idProvedor` int(11) NOT NULL,
  `NomEmpresa` varchar(50) NOT NULL,
  `NomLab` varchar(50) NOT NULL,
  `NomProv` varchar(50) NOT NULL,
  `NumeroProv` varchar(10) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quejas`
--
-- Creación: 22-11-2023 a las 01:46:16
--

CREATE TABLE `quejas` (
  `idQuejas` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Queja` varchar(50) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `sugerencia`
--
-- Creación: 22-11-2023 a las 01:47:06
--

CREATE TABLE `sugerencia` (
  `idSugerencia` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Sugerencia` varchar(50) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--
-- Creación: 22-11-2023 a las 01:11:23
-- Última actualización: 22-11-2023 a las 01:11:24
--

CREATE TABLE `usuario` (
  `iduser` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventamedicamento`
--
-- Creación: 22-11-2023 a las 01:34:09
--

CREATE TABLE `ventamedicamento` (
  `idVentaM` int(11) NOT NULL,
  `Producto` varchar(80) NOT NULL,
  `Precio` int(4) NOT NULL,
  `Cantidad` int(2) NOT NULL,
  `Total` int(4) NOT NULL,
  `idMedicamento` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `agcitas`
--
ALTER TABLE `agcitas`
  ADD PRIMARY KEY (`idCitas`),
  ADD KEY `fk1` (`iduser`);

--
-- Indices de la tabla `agmedicamento`
--
ALTER TABLE `agmedicamento`
  ADD PRIMARY KEY (`idMedicamento`),
  ADD KEY `fk3` (`idProvedor`);

--
-- Indices de la tabla `agprovedores`
--
ALTER TABLE `agprovedores`
  ADD PRIMARY KEY (`idProvedor`),
  ADD KEY `fk2` (`iduser`);

--
-- Indices de la tabla `quejas`
--
ALTER TABLE `quejas`
  ADD PRIMARY KEY (`idQuejas`),
  ADD KEY `fk5` (`iduser`);

--
-- Indices de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD PRIMARY KEY (`idSugerencia`),
  ADD KEY `fk6` (`iduser`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`iduser`);

--
-- Indices de la tabla `ventamedicamento`
--
ALTER TABLE `ventamedicamento`
  ADD PRIMARY KEY (`idVentaM`),
  ADD KEY `fk4` (`idMedicamento`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agmedicamento`
--
ALTER TABLE `agmedicamento`
  MODIFY `idMedicamento` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `agprovedores`
--
ALTER TABLE `agprovedores`
  MODIFY `idProvedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `quejas`
--
ALTER TABLE `quejas`
  MODIFY `idQuejas` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  MODIFY `idSugerencia` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `ventamedicamento`
--
ALTER TABLE `ventamedicamento`
  MODIFY `idVentaM` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `agcitas`
--
ALTER TABLE `agcitas`
  ADD CONSTRAINT `fk1` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`iduser`);

--
-- Filtros para la tabla `agmedicamento`
--
ALTER TABLE `agmedicamento`
  ADD CONSTRAINT `fk3` FOREIGN KEY (`idProvedor`) REFERENCES `agprovedores` (`idProvedor`);

--
-- Filtros para la tabla `agprovedores`
--
ALTER TABLE `agprovedores`
  ADD CONSTRAINT `fk2` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`iduser`);

--
-- Filtros para la tabla `quejas`
--
ALTER TABLE `quejas`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`iduser`);

--
-- Filtros para la tabla `sugerencia`
--
ALTER TABLE `sugerencia`
  ADD CONSTRAINT `fk6` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`iduser`);

--
-- Filtros para la tabla `ventamedicamento`
--
ALTER TABLE `ventamedicamento`
  ADD CONSTRAINT `fk4` FOREIGN KEY (`idMedicamento`) REFERENCES `agmedicamento` (`idMedicamento`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
