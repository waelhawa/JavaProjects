/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proj1;

class Employee implements Comparable<Employee> {

    private String degreeType, firstName, lastName, fullName;
    private int experience, degreeValue, valuePoint;

    Employee() {

        setDegreeType("None");
        setFirstName("Stan");
        setLastName("Dupp");
        setExperience(0);
        setDegreeValue(1);
    }

    Employee(String degreeType, String firstName, String lastName, int experience, int degreeValue) {
        setDegreeType(degreeType);
        setFirstName(firstName);
        setLastName(lastName);
        setExperience(experience);
        setDegreeValue(degreeValue);
        setValuePoint(experience, degreeValue);
        setFullName(firstName, lastName);

    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " has been with the company for " + experience + " years and has a degree level of " + degreeType;
    }

    public boolean equals(Employee employee) {
        this.valuePoint = this.degreeValue * this.experience;
        System.out.println(this.getFullName() + " has a point count of " + this.valuePoint + " and " + employee.getFullName() + " has " + employee.valuePoint);
        return (this.valuePoint == employee.valuePoint);
    }

    @Override
    public int compareTo(Employee employee) {
        int result = 0;
        if (this.valuePoint > employee.getValuePoint())
            result = 1;
        if (this.valuePoint < employee.getValuePoint())
            result = -1;
        return result;
    }

    public String getDegreeType() {
        return degreeType;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getExperience() {
        return experience;
    }

    public int getDegreeValue() {
        return degreeValue;
    }

    public int getValuePoint() {
        return valuePoint;
    }

    public String getFullName() {
        return fullName;
    }

    public void setDegreeType(String degreeType) {
        this.degreeType = degreeType;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setDegreeValue(int degreeValue) {
        this.degreeValue = degreeValue;
    }

    public void setValuePoint(int experience, int degreeValue) {
        this.valuePoint = experience * degreeValue;
    }

    public void setFullName(String firstName, String lastName) {
        this.fullName = firstName + " " + lastName;
    }

}
