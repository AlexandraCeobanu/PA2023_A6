package org.example.laborator4;
    public class Student implements Comparable<Student> {
        String name=new String();
        Student(String name)
        {
            this.name=name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
        @Override
        public int compareTo(Student other) {
            return this.name.compareTo(other.getName());
        }

        @Override
        public String toString() {
            return "Student{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
