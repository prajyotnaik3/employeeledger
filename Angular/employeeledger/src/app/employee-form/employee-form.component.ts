import { Component } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Employee } from '../../model/employee';
import { EmployeeService } from '../../service/employee.service';

@Component({
  selector: 'app-employee-form',
  templateUrl: './employee-form.component.html',
  styleUrls: ['./employee-form.component.css']
})
export class EmployeeFormComponent {
  employee: Employee; 
  constructor(
    private route: ActivatedRoute, 
    private router: Router,
    private employeeService: EmployeeService) {
      this.employee = new Employee();
  }

  onSubmit(){
    //console.log(this.employee);
    this.employeeService.save(this.employee).subscribe(result => this.gotoEmployeeList());
  }

  gotoEmployeeList(){
    this.router.navigate(['/getEmployees']);
  }
}
