import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';

@Component({
  selector: 'app-employee-edit',
  templateUrl: './employee-edit.component.html',
  styleUrls: ['./employee-edit.component.css']
})
export class EmployeeEditComponent {

  employee: Employee; 
  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private employeeService: EmployeeService) {
      this.employee = new Employee();//this.employeeService.getEmployeeSetForUpdate(); 
      this.employee = EmployeeService.updateEmp;
  }

  onSubmit(){
    //console.log(this.employee);
    this.employeeService.updateEmployee(this.employee).subscribe(result => this.gotoEmployeeList());
  }  

  gotoEmployeeList(){
    this.router.navigate(['/getEmployees']);
  }

  updateEmployee(employee: Employee){
    console.log(employee.employeeCode);
    this.employeeService.updateEmployee(employee);
  }
}
