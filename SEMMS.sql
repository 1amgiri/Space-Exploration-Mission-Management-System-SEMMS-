CREATE DATABASE semms;

USE semms;

CREATE TABLE Spacecraft (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    type VARCHAR(50) NOT NULL,
    capacity INT NOT NULL
);

CREATE TABLE Mission (
    id INT AUTO_INCREMENT PRIMARY KEY,
    mission_name VARCHAR(255) NOT NULL,
    destination VARCHAR(255) NOT NULL,
    launch_date DATE NOT NULL,
    spacecraft_id INT,
    FOREIGN KEY (spacecraft_id) REFERENCES Spacecraft(id)
);

INSERT INTO Spacecraft (id, name, type, capacity) VALUES 
(1, 'Apollo 1', 'Crewed', 3),
(2, 'Apollo 2', 'Crewed', 3),
(3, 'Gemini 3', 'Crewed', 2),
(4, 'Gemini 4', 'Crewed', 2),
(5, 'Saturn V', 'Uncrewed', 0),
(6, 'Falcon 1', 'Uncrewed', 0),
(7, 'Falcon 9', 'Crewed', 10),
(8, 'Starship 1', 'Crewed', 100),
(9, 'Starship 2', 'Crewed', 100),
(10, 'Atlas V', 'Uncrewed', 0);

INSERT INTO Mission (mission_name, destination, launch_date, spacecraft_id) VALUES 
('Apollo Moon Mission', 'Moon', '2025-07-20', 1),
('Lunar Survey Mission', 'Moon', '2025-11-11', 2),
('Gemini Mars Mission', 'Mars', '2026-01-15', 3),
('Gemini 4 Orbital Test', 'Low Earth Orbit', '2026-03-12', 4),
('Saturn V Lunar Probe', 'Moon', '2026-06-30', 5),
('Falcon 1 ISS Resupply', 'International Space Station', '2026-09-10', 6),
('Falcon 9 Mars Rover Deployment', 'Mars', '2026-12-22', 7),
('Starship 1 Mars Colonization', 'Mars', '2027-02-14', 8),
('Starship 2 Deep Space Mission', 'Jupiter', '2027-06-18', 9),
('Atlas V Venus Flyby', 'Venus', '2027-09-05', 10);

select Spacecraft.name, Mission.mission_name from Spacecraft
inner join Mission on
Spacecraft.id = Mission.spacecraft_id;


