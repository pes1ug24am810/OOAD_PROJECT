-- 1. Insert 5 Employees into the main 'employees' table
INSERT INTO employees (emp_id, email, department, designation, date_of_joining, basic_pay) VALUES 
('EMP001', 'alice@company.com', 'Engineering', 'Software Engineer', '2026-01-15', 75000),
('EMP002', 'bob@company.com', 'HR', 'HR Manager', '2025-05-10', 85000),
('EMP003', 'charlie@company.com', 'Engineering', 'DevOps Engineer', '2026-03-01', 80000),
('EMP004', 'diana@company.com', 'Marketing', 'Marketing Specialist', '2024-11-20', 60000),
('EMP005', 'evan@company.com', 'Sales', 'Sales Executive', '2023-08-05', 65000);

-- 2. Insert the secure login credentials for these 5 employees
-- The hash 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f' equals 'password123'
INSERT INTO ess_auth_credentials (emp_code, username, password_hash, account_locked, failed_attempts) VALUES 
('EMP001', 'alice@company.com', 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f', 0, 0),
('EMP002', 'bob@company.com', 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f', 0, 0),
('EMP003', 'charlie@company.com', 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f', 0, 0),
('EMP004', 'diana@company.com', 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f', 0, 0),
('EMP005', 'evan@company.com', 'ef92b778bafe771e89245b89ecbc08a44a4e166c06659911881f383d4473e94f', 0, 0);

-- 3. Verify the data was inserted successfully
SELECT * FROM employees;