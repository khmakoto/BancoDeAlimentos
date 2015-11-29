USE BancoDeAlimentos;

DELETE FROM MovCarAbo;
DELETE FROM FoliosCarAbo;
DELETE FROM Areas;
DELETE FROM Programas;
DELETE FROM Instituciones;

INSERT INTO Instituciones(IDInstitucion, Institucion, Activo) VALUES('0000000001', 'C.P. Nuestra Señora de la Soledad, Escobedo', 1);
INSERT INTO Instituciones(IDInstitucion, Institucion, Activo) VALUES('0000000002', 'Alianza Real 2', 1);

INSERT INTO Areas(IDArea, Area) VALUES('000001', 'Apoyo a O.S.C.');
INSERT INTO Areas(IDArea, Area) VALUES('000002', 'Nutrición Rural');

INSERT INTO Programas(IDPrograma, Programa) VALUES('000001', 'Apoyo a organismos');
INSERT INTO Programas(IDPrograma, Programa) VALUES('000002', 'Alimentación básico rural');

INSERT INTO FoliosCarAbo(FolioCarAbo) VALUES('0000000001');
INSERT INTO FoliosCarAbo(FolioCarAbo) VALUES('0000000002');
INSERT INTO FoliosCarAbo(FolioCarAbo) VALUES('0000000003');
INSERT INTO FoliosCarAbo(FolioCarAbo) VALUES('0000000004');

INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (1, '0000000001', '000001', '000001', '0000000001', 'Abono', '0000000001', '2015-10-14', 510, 0, NULL, 'Pendiente', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (2, '0000000001', '000002', '000002', '0000000002', 'Abono', '0000000002', '2015-10-15', 510, 0, NULL, 'Pendiente', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (3, '0000000002', '000001', '000001', '0000000003', 'Abono', '0000000003', '2015-11-26', 510, 0, NULL, 'Pendiente', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (4, '0000000002', '000002', '000002', '0000000004', 'Abono', '0000000004', '2015-11-27', 510, 0, NULL, 'Pendiente', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (1, '0000000001', '000001', '000001', '0000000005', 'Abono', '0000000005', '2015-10-14', 0, 510, NULL, 'Pagado', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (2, '0000000001', '000001', '000001', '0000000006', 'Abono', '0000000006', '2015-10-15', 0, 510, NULL, 'Pagado', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (3, '0000000002', '000001', '000001', '0000000007', 'Abono', '0000000007', '2015-11-26', 0, 510, NULL, 'Pagado', 510, 0, 0, 0);
INSERT INTO MovCarAbo(IDMovCarAbo, IDInstitucion, IDArea, IDPrograma, IDFolioCarAbo, TipoMov, IDFolio, FechaMov, Importe, Abono, Referencia, Estatus, Saldo, Bonificacion, Donativo, Incobrable) VALUES (4, '0000000002', '000002', '000002', '0000000008', 'Abono', '0000000008', '2015-11-27', 0, 510, NULL, 'Pagado', 510, 0, 0, 0);