package models.person.employee;

import constant.Salary;

public class SalaryStrategy1 implements ISalary {

	@Override
	public double salary(Employee emp) {
		double totalSalary = 0;
		for (TimeSheet t : emp.getLatestTimeWork().getTimeSheeats()) {
			if (t.getIsLate()) {
				totalSalary += emp.salaryByPosition() - Salary.fee_late;
			}
			totalSalary += emp.salaryByPosition();
		}
		return totalSalary;
	}

}
