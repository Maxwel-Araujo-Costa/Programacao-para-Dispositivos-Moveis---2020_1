package com.maxwel.prova;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemCardapio implements Serializable {
    public String nome;
    public int imagem;
    public double preco;
    public int quantidade;

    public ItemCardapio (String nome, int imagem, double preco, int quantidade){
        this.nome=nome;
        this.imagem=imagem;
        this.preco=preco;
        this.quantidade=quantidade;
    }

    public static List<ItemCardapio> getCardapio(){
        List<ItemCardapio> cardapio=new ArrayList<ItemCardapio>();
        cardapio.add(new ItemCardapio("Big Bacon Triplo Classico", R.drawable.big_bacon_triplo_classico, 8.09,1));
        cardapio.add(new ItemCardapio("Sanduiche Picante de Frango Empanado", R.drawable.sanduiche_picante_de_frango_empanado, 0.99,1));
        cardapio.add(new ItemCardapio("Batata Frita", R.drawable.batata_frita, 2.19,1));
        cardapio.add(new ItemCardapio("Batata Recheada com Cream Cheese e Bacon", R.drawable.batata_recheada_com_cream_cheese_e_bacon, 2.79,1));
        cardapio.add(new ItemCardapio("Salada Taco", R.drawable.salada_taco, 4.69,1));
        cardapio.add(new ItemCardapio("Coca Cola", R.drawable.coca_cola, 2.19,1));
        cardapio.add(new ItemCardapio("Sprite", R.drawable.sprite, 2.19,1));
        cardapio.add(new ItemCardapio("Café", R.drawable.cafe, 1.49,1));
        return cardapio;
    }
    public static List<ItemCardapio> carrinho;
    public static List<ItemCardapio> getCarrinho(){
        return carrinho;
    }
    public static void setCarrinho(List<ItemCardapio> newCarrinho){
        carrinho=new ArrayList<ItemCardapio>();
        carrinho = newCarrinho;
    }
}
