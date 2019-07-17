import { Component, OnInit } from '@angular/core';
import { HttpClient } from "@angular/common/http";

@Component({
  selector: 'app-user-profile',
  templateUrl: './user-profile.component.html',
  styleUrls: ['./user-profile.component.css']
})
export class UserProfileComponent implements OnInit {

  public password: any;
  public username: any;
  public message: any;
  public type: any;

  constructor(private httpClient: HttpClient) { }

  ngOnInit() {
    this.username = "chandra";
  }

  onSubmit() {
    console.log(this.password);
    const user = {
      "userName": this.username,
      "password": this.password
    };
    this.httpClient.post<any>("/employee/api/v1/profile", user).subscribe(
      response => {
        console.log(response);
        this.type = "alert-success";
        this.message = "Password updated successfully";
        setTimeout(() => { this.message = undefined; }, 5000);
      }, error => {
        this.type = "alert-danger";
        this.message = "Password updation failed";
        setTimeout(() => { this.message = undefined; }, 5000);
        console.log(error);
      });

  }
}
