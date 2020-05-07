import { NgModule } from '@angular/core';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AuthInterceptorService } from './auth-interceptor.service';
import { AuthService } from './auth-service.component';
import { AccountService } from './account.service';
import { ProjectService } from './project.service';
import { AdminRouteGuard } from './admin-route-guard';
import { HeroService } from './hero.service';

@NgModule({
    imports: [],
    exports: [],
    declarations: [],
    providers: [
        AuthService,
        AccountService,
        ProjectService,
        HeroService,
        AdminRouteGuard,
        { provide: HTTP_INTERCEPTORS, useClass: AuthInterceptorService, multi: true }
    ],
})
export class CoreModule { }
