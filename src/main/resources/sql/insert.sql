INSERT INTO lpg_monitoring.company (name, info, tax) VALUE ('LM-Trade','2012','100');
INSERT INTO lpg_monitoring.company (name, info, tax) VALUE ('AutoGaz','2010','110');

INSERT INTO lpg_monitoring.user (name, email, phone, password, company_id) VALUE ('Taras', 'yt@gail.com','0991234567','1111',1);
INSERT INTO lpg_monitoring.user (name, email, phone, password, company_id) VALUE ('Svetlana', 'sc@gail.com','0931234567','1111',1);

INSERT INTO lpg_monitoring.measure_system (serialnumber, description, placement, inspection, company_id)
  VALUE ('123456','First system in company','car','2012-12-1 12:14:00',1);

INSERT INTO lpg_monitoring.event (date, type, value, temperature, location, measure_system_id)
  VALUE ('2012-12-12 12:12','IN','1000','13','ukr',1);