CREATE TABLE if not exists todo (
                      id SERIAL PRIMARY KEY,
                      title VARCHAR(255) NOT NULL,
                      description TEXT,
                      completed BOOLEAN DEFAULT false,
                      belongTo VARCHAR(255) NOT NULL
);
