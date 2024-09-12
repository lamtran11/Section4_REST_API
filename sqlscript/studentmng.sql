CREATE TABLE students (
    student_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    birthdate DATE,
    address TEXT,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: courses
CREATE TABLE courses (
    course_id SERIAL PRIMARY KEY,
    course_name VARCHAR(100) NOT NULL,
    description TEXT,
    credit_hours INT NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: enrollments (links students to courses)
CREATE TABLE enrollments (
    enrollment_id SERIAL PRIMARY KEY,
    student_id INT REFERENCES students(student_id) ON DELETE CASCADE,
    course_id INT REFERENCES courses(course_id) ON DELETE CASCADE,
    enrollment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    grade CHAR(2)
);

-- Table: instructors
CREATE TABLE instructors (
    instructor_id SERIAL PRIMARY KEY,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    hire_date DATE,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: course_instructors (assign instructors to courses)
CREATE TABLE course_instructors (
    course_instructor_id SERIAL PRIMARY KEY,
    course_id INT REFERENCES courses(course_id) ON DELETE CASCADE,
    instructor_id INT REFERENCES instructors(instructor_id) ON DELETE CASCADE,
    assigned_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: departments (organizes courses into departments)
CREATE TABLE departments (
    department_id SERIAL PRIMARY KEY,
    department_name VARCHAR(100) NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Table: course_departments (assigns courses to departments)
CREATE TABLE course_departments (
    course_department_id SERIAL PRIMARY KEY,
    course_id INT REFERENCES courses(course_id) ON DELETE CASCADE,
    department_id INT REFERENCES departments(department_id) ON DELETE CASCADE,
    assigned_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);











