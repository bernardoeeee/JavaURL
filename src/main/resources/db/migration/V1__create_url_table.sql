CREATE TABLE url
(
    id          UUID                   DEFAULT gen_random_uuid() PRIMARY KEY,
    url_default VARCHAR(2082) NOT NULL,
    url_short   VARCHAR(50),
    created_at  TIMESTAMPTZ   NOT NULL DEFAULT NOW(),
    CONSTRAINT uk_url_short UNIQUE (url_short)
);