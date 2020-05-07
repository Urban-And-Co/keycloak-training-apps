import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, from } from 'rxjs';
import { Constants } from '../constants';
import { AuthService } from './auth-service.component';
import { Hero } from '../model/hero';

@Injectable()
export class HeroService {
  constructor(private _httpClient: HttpClient,
              private _authService: AuthService) {
  }

  getHeroes(): Observable<Hero[]> {
    return from(this._authService.getAccessToken().then(token => {
      const headers = new HttpHeaders().set('Authorization', `Bearer ${token}`);
      return this._httpClient.get<Hero[]>(Constants.apiRoot + 'heroes', {headers: headers}).toPromise();
    }));
  }
}
