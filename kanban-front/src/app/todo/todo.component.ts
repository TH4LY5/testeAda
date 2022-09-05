import { CdkDragDrop, moveItemInArray, transferArrayItem } from '@angular/cdk/drag-drop';
import { Component, OnInit } from '@angular/core';
import {FormGroup, FormBuilder, Validators} from '@angular/forms';
import { Iatividade } from '../models/atividade';
@Component({
  selector: 'app-todo',
  templateUrl: './todo.component.html',
  styleUrls: ['./todo.component.scss']
})
export class TodoComponent implements OnInit {
todoForm !: FormGroup;
atividade: Iatividade[] = [];
emprogresso: Iatividade[] = [];
atvFinalizado: Iatividade[] = [];
indexAtulizarAtividade!: any;
habilitarEdicao:boolean = false;
  constructor(private formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this.todoForm = this.formBuilder.group({
      item: ['', Validators.required]
    })
  }

  addAtividade(){
    this.atividade.push({
      descricao:this.todoForm.value.item,
      finalizado:false
    });
    this.todoForm.reset()
  }

  editar(item:Iatividade, i: number){
    this.todoForm.controls['item'].setValue(item.descricao);
    this.indexAtulizarAtividade = i;
    this.habilitarEdicao = true;
  }

  updateAtividade(){
    this.atividade[this.indexAtulizarAtividade].descricao = this.todoForm.value.item;
    this.atividade[this.indexAtulizarAtividade].finalizado = false;
    this.todoForm.reset();
    this.indexAtulizarAtividade = undefined;
    this.habilitarEdicao = false;
  }

  deleteAtivadade(i: number){
    this.atividade.splice(i,1)
  }
  deleteAtivadadeEmProgresso(i: number){
    this.emprogresso.splice(i,1)
  }

  deleteAtivadadeFinalizada(i: number){
    this.atvFinalizado.splice(i,1)
  }
  drop(event: CdkDragDrop<Iatividade[]>) {
    if (event.previousContainer === event.container) {
      moveItemInArray(event.container.data, event.previousIndex, event.currentIndex);
    } else {
      transferArrayItem(
        event.previousContainer.data,
        event.container.data,
        event.previousIndex,
        event.currentIndex,
      );
    }
  }

}
