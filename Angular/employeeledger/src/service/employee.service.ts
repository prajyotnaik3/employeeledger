import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Employee } from '../model/employee';
import { Observable } from 'rxjs/Observable';


@Injectable()
export class EmployeeService {
  private getEmployeesURL: string;
  private addEmployeeURL: string;
  private deleteEmployeeURL: string;
  private updateEmployeeURL: string;

  static updateEmp: Employee = new Employee();

  constructor(private http: HttpClient) { 
    this.getEmployeesURL = 'http://localhost:8088/restapi/getEmployees';
    this.addEmployeeURL = 'http://localhost:8088/restapi/addEmployee';
    this.deleteEmployeeURL = 'http://localhost:8088/restapi/deleteEmployees/';
    this.updateEmployeeURL = 'http://localhost:8088/restapi/updateEmployees/';
  }

  public findall(): Observable<Employee[]>{
    return this.http.get<Employee[]>(this.getEmployeesURL);
  }

  public save(employee: Employee):Observable<Employee>{
    console.log(employee);
    const headers = new HttpHeaders({ 'Content-Type': 'application/json','accept': 'application/json' });
    //let str: string;
    return this.http.post<Employee>(this.addEmployeeURL, employee, {headers: headers});
  }

  public deleteEmployee(empCode: number){
    let url = this.deleteEmployeeURL + empCode;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json','accept': 'application/json' });
    console.log(url);
    return this.http.delete(this.deleteEmployeeURL+empCode, {headers: headers});
  }

  public updateEmployee(employee: Employee):Observable<Employee>{
    let url = this.updateEmployeeURL + employee.employeeCode;
    const headers = new HttpHeaders({ 'Content-Type': 'application/json','accept': 'application/json' });
    console.log(url);
    return this.http.put<Employee>(url, employee, {headers: headers});
  }
}
