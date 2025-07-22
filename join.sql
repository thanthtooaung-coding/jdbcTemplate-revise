SELECT 
    students.id,
    students.name,
    courses.course_name
FROM 
    students
INNER JOIN 
    courses ON students.id = courses.student_id;
