CREATE TABLE IF NOT EXIST(
id INTEGER AUTO_INCREMENT,
title varchar(255) NOT NULL,
description TEXT,
status varchar(20) NOT NULL,
content_type varchar(25) NOT NULL,
date_created TIMESTAMP NOT NULL,
date_updated TIMESTAMP,
url VARCHAR(255),
PRIMARY KEY(id)
);