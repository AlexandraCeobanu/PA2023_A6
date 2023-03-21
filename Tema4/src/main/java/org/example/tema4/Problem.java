package org.example.tema4;

import java.util.*;

public class Problem {

    private int averageNumberPreferences;
   private Map<Student,Project> pairsMap=new HashMap<>();
   private List<Student> studentList=new ArrayList<>();
   private List<Project> projectList=new ArrayList<>();
    Problem()
    {
        averageNumberPreferences=0;
    }
    public void addStudents(Student student)
    {
        studentList.add(student);
    }
    public void addProjects(Project project)
    {
        projectList.add(project);
    }
    public void calculateAverage()
    {
        int sum=0;
        for(Student s: studentList)
        {
            sum=sum+s.getNumberOfAdmissibleProjects();
        }
        averageNumberPreferences=sum/projectList.size();
    }

    public int getAverageNumberPreferences() {
        return averageNumberPreferences;
    }

    public void printStudents()
    {
        calculateAverage();
        studentList.stream()
                .filter(s ->s.getNumberOfAdmissibleProjects()<averageNumberPreferences)
                .forEach(System.out::println);
    }
    public void findPairs()
    {
        Collections.sort(studentList);
        List<Project> availableProjects=projectList;
        for(Student s:studentList)
        {
            List<Project> admissibleProjects=s.getAdmissibleProjects();
            int p=0;
            while(p< s.getNumberOfAdmissibleProjects() && availableProjects.contains(admissibleProjects.get(p))==false)
            {
                ++p;
            }
            if(availableProjects.contains(admissibleProjects.get(p))==true)
            {
                pairsMap.put(s,admissibleProjects.get(p));
                availableProjects.remove(admissibleProjects.get(p));
            }
        }
    }

    @Override
    public String toString() {
        return "Problem{" +
                "pairsMap=" + pairsMap +
                '}';
    }
}
