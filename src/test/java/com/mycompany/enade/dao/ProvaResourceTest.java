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
        Mockito.when(provaResource.findAll()).thenReturn(provaList);
        assertEquals(provaList, provaResource.findAll());
    }

    @Test
    public void testFind() {
        Mockito.when(provaResource.find(prova.getIdProva())).thenReturn(prova);
        assertEquals(prova, provaResource.find(prova.getIdProva()));
    }

    @Test
    public void testMerge() {
        Mockito.when(provaResource.merge(prova)).thenReturn("");
        assertEquals("", provaResource.merge(prova));
    }

    @Test
    public void testRemoveAll() {
        Mockito.when(provaResource.removeAll()).thenReturn("");
        assertEquals("", provaResource.removeAll());
    }

    @Test
    public void testRemove() {
        Mockito.when(provaResource.remove(prova.getIdProva())).thenReturn("");
        assertEquals("", provaResource.remove(prova.getIdProva()));
    }

}