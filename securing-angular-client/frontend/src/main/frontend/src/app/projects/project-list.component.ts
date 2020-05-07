import { Component, OnInit } from '@angular/core';
import { MatTableDataSource } from '@angular/material';

import { Utils } from '../core/utils';
import { Hero } from '../model/hero';
import { HeroService } from '../core/hero.service';

@Component({
  selector: "app-projects",
  templateUrl: "project-list.component.html"
})
export class ProjectListComponent implements OnInit {
  displayedColumns = ["name"];
  error: string;
  dataSource = new MatTableDataSource();
  heroes: Hero[];

  constructor(private _heroService: HeroService) {}

  ngOnInit() {
    this._heroService.getHeroes().subscribe(heroes => {
      this.heroes = heroes;
      this.dataSource.data = heroes;
    }, error => Utils.formatError(error));
  }
}
