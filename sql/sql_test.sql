INSERT INTO `project`.`test`
(`memo`)
VALUES
('test memo2');

UPDATE `project`.`test`
SET
`test memo2` = "edit memo"
WHERE `idx` = 2;

DELETE FROM project.test
WHERE idx=2;
