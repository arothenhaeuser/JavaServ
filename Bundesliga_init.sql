CREATE DATABASE IF NOT EXISTS Bundesliga;
USE Bundesliga;
CREATE TABLE IF NOT EXISTS Abgeordnete(
	LastName varchar(255),
	FirstName varchar(255),
	DateOfBirth date,
	Job varchar(255),
	Qualification varchar(255),
	Picture varchar(255),
	StatusID tinyint,
	CityID tinyint,
	ProvinceID tinyint,
	PartyID tinyint,
	ConfessionID tinyint
);
CREATE TABLE IF NOT EXISTS Stati(
	ID tinyint,
	Label varchar(255)
);
CREATE TABLE IF NOT EXISTS Cities(
	ID tinyint,
	Label varchar(255)
);
CREATE TABLE IF NOT EXISTS Provinces(
	ID tinyint,
	Label varchar(255),
	Emblem image,
	Capital varchar(255)
);
CREATE TABLE IF NOT EXISTS Parties(
	ID tinyint,
	Label varchar(255),
	Emblem image,
	Leader varchar(255),
	Chairman varchar(255)
);
CREATE TABLE IF NOT EXISTS Confessions(
	ID tinyint,
	Label varchar(255)
);