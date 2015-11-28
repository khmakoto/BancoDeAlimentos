USE BancoDeAlimentos;

DELETE FROM MovCarAbo;
DELETE FROM FoliosCarAbo;
DELETE FROM Areas;
DELETE FROM Programas;
DELETE FROM Instituciones;

INSERT INTO Instituciones(IDInstitucion, Institucion, Activo) VALUES('0000000001', 'C.P. Nuestra Señora de la Soledad, Escobedo', 1);

INSERT INTO Areas(IDArea, Area) VALUES('000001', 'Apoyo a O.S.C.');

INSERT INTO Programas(IDPrograma, Programa) VALUES('000001', 'Apoyo a organismos');

INSERT INTO FoliosCarAbo(FolioCarAbo) VALUES('0000000001');

INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (1, '0000000001', '000001', '000001', '0000000001', 'Abono', '0000000001', '2015-11-27', 510, 0, NULL, 'Pendiente', 510, 0, 0, 0);