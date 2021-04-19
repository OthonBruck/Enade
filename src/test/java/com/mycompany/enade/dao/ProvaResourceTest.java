/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.enade.dao;

import com.mycompany.enade.model.Prova;
import com.mycompany.enade.resources.ProvaResource;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;

/**
 *
 * @author Pichau
 */
public class ProvaResourceTest {

    ProvaResource provaResource = mock(ProvaResource.class);
    List<Prova> provaList = new ArrayList<>();
    Prova prova = mock(Prova.class);

    public ProvaResourceTest() {
    }

    @Test
    public void testFindAll() {
        provaList.add(prova);
        Mockito.when(provaResource.TodasProvas()).thenReturn(provaList);
        assertEquals(provaList, provaResource.TodasProvas());
    }

    @Test
    public void testFind() {
        Mockito.when(provaResource.GetProva(prova.getIdProva())).thenReturn(prova);
        assertEquals(prova, provaResource.GetProva(prova.getIdProva()));
    }

    @Test
    public void testMerge() {
        Mockito.when(provaResource.Alterar(prova)).thenReturn("");
        assertEquals("", provaResource.Alterar(prova));
    }

    @Test
    public void testRemoveAll() {
        Mockito.when(provaResource.ExcluirTodas()).thenReturn("");
        assertEquals("", provaResource.ExcluirTodas());
    }

    @Test
    public void testRemove() {
        Mockito.when(provaResource.Excluir(prova.getIdProva())).thenReturn("");
        assertEquals("", provaResource.Excluir(prova.getIdProva()));
    }

}