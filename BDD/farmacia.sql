-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 27-11-2023 a las 02:05:17
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

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agcitas`
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

--
-- Volcado de datos para la tabla `agcitas`
--

INSERT INTO `agcitas` (`idCitas`, `NomC`, `Fecha`, `Direccion`, `Sexo`, `NumTel`, `Sintomas`, `iduser`) VALUES
(1, 'Gustavo', '26/11/23', 'Av.Pachuca Donas', 'Hombre', '55481', 'Dolor de Cabeza', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agmedicamento`
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

--
-- Volcado de datos para la tabla `agmedicamento`
--

INSERT INTO `agmedicamento` (`idMedicamento`, `Medicamento`, `Provedor`, `Tipo`, `Stock`, `Precio`, `idProvedor`) VALUES
(1, 'Gas', 'T', 't', 1, 30, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `agprovedores`
--

CREATE TABLE `agprovedores` (
  `idProvedor` int(11) NOT NULL,
  `NomEmpresa` varchar(50) NOT NULL,
  `NomLab` varchar(50) NOT NULL,
  `NomProv` varchar(50) NOT NULL,
  `NumeroProv` varchar(10) NOT NULL,
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `agprovedores`
--

INSERT INTO `agprovedores` (`idProvedor`, `NomEmpresa`, `NomLab`, `NomProv`, `NumeroProv`, `iduser`) VALUES
(12, 'sad', 'asd', 'asd', 'asd', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleventa`
--

CREATE TABLE `detalleventa` (
  `idDetalle` int(11) NOT NULL,
  `idVentaM` int(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `Cantidad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `quejas`
--

CREATE TABLE `quejas` (
  `idQuejas` int(11) NOT NULL,
  `Nombre` varchar(30) NOT NULL,
  `Tipo` varchar(20) NOT NULL,
  `Texto` varchar(50) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `iduser` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `iduser` int(11) NOT NULL,
  `Nombre` varchar(50) NOT NULL,
  `Contraseña` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuario`
--

INSERT INTO `usuario` (`iduser`, `Nombre`, `Contraseña`) VALUES
(1, '1', '123');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventamedicamento`
--

CREATE TABLE `ventamedicamento` (
  `idVentaM` int(11) NOT NULL,
  `Producto` varchar(80) NOT NULL,
  `Monto` int(10) NOT NULL,
  `fecha` timestamp NOT NULL DEFAULT current_timestamp() ON UPDATE current_timestamp(),
  `Folio` varchar(11) NOT NULL,
  `idMedicamento` int(11) NOT NULL,
  `iduser` int(11) NOT NULL
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
-- Indices de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `fkidM` (`idVentaM`),
  ADD KEY `fkventMd` (`idMedicamento`);

--
-- Indices de la tabla `quejas`
--
ALTER TABLE `quejas`
  ADD PRIMARY KEY (`idQuejas`),
  ADD KEY `fk5` (`iduser`);

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
  ADD KEY `fk4` (`idMedicamento`),
  ADD KEY `fkId` (`iduser`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `agcitas`
--
ALTER TABLE `agcitas`
  MODIFY `idCitas` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `agmedicamento`
--
ALTER TABLE `agmedicamento`
  MODIFY `idMedicamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `quejas`
--
ALTER TABLE `quejas`
  MODIFY `idQuejas` int(11) NOT NULL AUTO_INCREMENT;

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
-- Filtros para la tabla `detalleventa`
--
ALTER TABLE `detalleventa`
  ADD CONSTRAINT `fkidM` FOREIGN KEY (`idVentaM`) REFERENCES `ventamedicamento` (`idVentaM`),
  ADD CONSTRAINT `fkventMd` FOREIGN KEY (`idMedicamento`) REFERENCES `agmedicamento` (`idMedicamento`);

--
-- Filtros para la tabla `quejas`
--
ALTER TABLE `quejas`
  ADD CONSTRAINT `fk5` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`iduser`);

--
-- Filtros para la tabla `ventamedicamento`
--
ALTER TABLE `ventamedicamento`
  ADD CONSTRAINT `fk4` FOREIGN KEY (`idMedicamento`) REFERENCES `agmedicamento` (`idMedicamento`),
  ADD CONSTRAINT `fkId` FOREIGN KEY (`iduser`) REFERENCES `usuario` (`iduser`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
