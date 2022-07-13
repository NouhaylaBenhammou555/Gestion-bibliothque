 
CREATE TABLE CLIENT(
NO 	 NUMBER(7) 								,
NOM 	 VARCHAR2(50) 								,
PRENOM	 VARCHAR2(25)  								,
ADRESSE  VARCHAR2(200)								,
VILLE 	 VARCHAR2(30) DEFAULT 'Casa'						,
PAYS 	 VARCHAR2(30) DEFAULT 'Maroc'						,
CONSTRAINT PK_CLIENT primary key (NO)						,
CONSTRAINT CNN_NOM_CLIENT CHECK (NOM IS NOT NULL)				,
CONSTRAINT CNN_PRENOM_CLIENT CHECK (PRENOM IS NOT NULL)				,
CONSTRAINT CV_PAYS_CLIENT CHECK (Pays IN ('Maroc','France','Tunisie','Espagne'))
);

 


 Create Table Produit (
 	NO NUMBER(7),
 	nom varchar2(30),
 	description varchar2(200),
 	prix_conseille NUMBER(11,2),
 	CONSTRAINT PK_Produit primary key (NO)	,
 	CONSTRAINT CNN_NOM_Produit CHECK (nom is NOT NULL),
 	CONSTRAINT CNN_PRIX_CONSEILLE CHECK (prix_conseille is NOT NULL AND prix_conseille > 0)
);

  CREATE TABLE Commande(
     NO NUMBER(7),
     CLIENT_NO NUMBER(7),
     Date_Commande DATE,
     Date_livraison DATE,
     CONSTRAINT PK_Commande primary key (NO),
     CONSTRAINT FK_Commande foreign key (CLIENT_NO) REFERENCES CLIENT(NO),
     CONSTRAINT CNN_Date_Commande CHECK (Date_Commande is NOT NULL),
     CONSTRAINT CNN_Date_livraison CHECK (Date_livraison is NOT NULL AND Date_Commande < Date_livraison)
);

  CREATE TABLE LIGNE_COM(
     Commande_NO NUMBER(7),
     Produit_NO NUMBER(7),
     Prix_Vente NUMBER(11,2),
     Quantite    NUMBER(9),
     CONSTRAINT PK_LIGNE_COM primary key (Commande_NO,Produit_NO),
     CONSTRAINT CNN_QUANTITE CHECK (Quantite is NOT NULL AND Quantite >0),
     CONSTRAINT CNN_PRIX_VENTE CHECK (Prix_Vente is NOT NULL AND Prix_Vente >0)
  	);

  alter table client modify nom varchar2(60);
 
  alter table client add date_naissance DATE ;

  alter table client modify adresse varchar2(50)    CHECK (adresse is NOT NULL);

  alter table produit modify description varchar2(100);

  alter table produit DROP COLUMN description ;

  alter table LIGNE_COM add reduction NUMBER(7) Default 0 ;

  insert into LIGNE_COM (Commande_NO,Produit_NO,Prix_Vente,Quantite ) values (1,23,200,15);

  alter table LIGNE_COM rename COLUMN reduction to ristourne;

  ALTER TABLE LIGNE_COM  RENAME TO Detail_COM ;

  create table employe(
	NO NUMBER(7),
	NOM VARCHAR2(30),
	PRENOM VARCHAR2(30),
	CONSTRAINT PK_EMPLOYE PRIMARY KEY(NO)
);


  insert into commande values (30,1,'01-05-2021','01-10-2021');