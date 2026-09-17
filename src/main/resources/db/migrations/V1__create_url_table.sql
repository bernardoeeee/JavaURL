CREATE EXTENSION IF NOT EXISTS "pgcrypto";

CREATE TABLE url(
    id UUID DEFAULT gen_random_uuid() PRIMARY KEY,
    urlDefault varchar(2082) not null,
    urlShort varchar(2082)
)