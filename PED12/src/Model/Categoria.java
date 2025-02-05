/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.text.Collator;
import java.util.Comparator;

/**
 *
 * @author alan
 * @author DAVI
 */
public class Categoria {

    private int CategiaId;
    private String CategoriaTipo;
    private int id_conta;
    private String Categoria_aux;
    
    public Categoria(CategoriaBuild build){
        this.CategiaId = build.CategiaId;
        this.CategoriaTipo = build.CategoriaTipo;
        this.id_conta = build.id_conta;
        this.Categoria_aux = build.Categoria_aux;
    }
   
    public static class CategoriaBuild{
        private int CategiaId;
        private String CategoriaTipo;
        private int id_conta;
        private String Categoria_aux; 
        
        
        public CategoriaBuild CategiaId(int categoriaId){
            this.CategiaId = categoriaId;
            return this;
        }
         
        public CategoriaBuild CategoriaTipo(String categoriaTipo){
            this.CategoriaTipo = categoriaTipo;
            return this;
        }
          
        public CategoriaBuild id_conta(int idConta){
            this.id_conta = idConta;
            return this;
        }
        
        public CategoriaBuild Categoria_aux(String categotia_aux){
            this.Categoria_aux = categotia_aux;
            return this;
        }
          
        public Categoria build(){
            return new Categoria(this);
        }
    }
   
    public int getCategoriaId() {
        return CategiaId;
    }

    public void setCategoriaId(int CategiaId) {
        this.CategiaId = CategiaId;
    }

    public String getCategoriaTipo() {
        return CategoriaTipo;
    }

    public void setCategoriaTipo(String CategoriaTipo) {
        this.CategoriaTipo = CategoriaTipo;
    }
    
    public int getId_conta() {
        return id_conta;
    }

    public void setId_conta(int id_conta) {
        this.id_conta = id_conta;
    }
    
    
    public String getCategoria_aux() {
        return Categoria_aux;
    }

    public void setCategoria_aux(String Categoria_aux) {
        this.Categoria_aux = Categoria_aux;
    }
    
    public static class CategoriaASC implements Comparator<Categoria> {

        public CategoriaASC() {

        }

        @Override
        public int compare(Categoria c, Categoria c1) {

            // c é maior que c1
            if (Collator.getInstance().compare(c.getCategoriaTipo(), c1.getCategoriaTipo()) > 0) {
                return 1;

            } else if (Collator.getInstance().compare(c.getCategoriaTipo(), c1.getCategoriaTipo()) < 0) {
                // c é menor que c1
                return -1;

            } else {
                // são iguais
                return 0;
            }
        }
    } 
    
    public static class CategoriaDESC implements Comparator<Categoria> {

        public CategoriaDESC() {

        }

        @Override
        public int compare(Categoria c, Categoria c1) {

            // c é maior que c1
            if (Collator.getInstance().compare(c.getCategoriaTipo(), c1.getCategoriaTipo()) > 0) {
                return -1;

            } else if (Collator.getInstance().compare(c.getCategoriaTipo(), c1.getCategoriaTipo()) < 0) {
                // c é menor que c1
                return 1;

            } else {
                // são iguais
                return 0;
            }
        }
    }
    
}
