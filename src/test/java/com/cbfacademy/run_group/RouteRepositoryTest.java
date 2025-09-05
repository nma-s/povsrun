package com.cbfacademy.run_group;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.nullable;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cbfacademy.povsrun_group.routes.Route;
import com.cbfacademy.povsrun_group.routes.RouteRepository;

/*
 * Unit Tests for RouteRepository custom methods
 * Tests only for the custom methods in route repository 
 * Inherited ListCrudRepository are tested by Spring JPA
 */
@ExtendWith(MockitoExtension.class)
public class RouteRepositoryTest {
    @Mock
    private RouteRepository routeRepository;
    private Route testRoute1;
    private Route testRoute2;
    private Route testRoute3;

    @BeforeEach
    void setUp(){
    testRoute1 = new Route("8.5K Social Run", 8.5f,"Elephant & Castle",List.of("Vauxhall Bridge", "Covent Garden"));
    testRoute2 = new Route("5K Social Run", 5f,"Elephant & Castle",List.of("Blackfriars Bridge"));  
    testRoute3 = new Route("10K Social Run", 11.5f,"Elephant & Castle",List.of("Waterloo Bridge", "Strand", "Blackfriars Bridge"));
    }

    @Test
    @DisplayName("findByDistanceInKm returns one matching route")
    void testFindByDistanceInKm_ReturnMatchingRoute(){
        // Arrange
        List<Route> expectedRoutes = List.of(testRoute1);
        when(routeRepository.findByDistanceInKm(8.5f)).thenReturn(expectedRoutes);
        
        // Act
        List<Route> result = routeRepository.findByDistanceInKm(8.5f);

        // Assert
        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(testRoute1, result.get(0));
        verify(routeRepository).findByDistanceInKm(8.5f);
    }

    @Test
    @DisplayName("test findByDistanceInKm returns empty list for no matching route")
    void testFindByDistanceInKm_ReturnEmptyList_WhenNoMatchingRoute() {
        // Arrange
        List<Route> expectedRoutes = List.of();
        when(routeRepository.findByDistanceInKm(9.5f)).thenReturn(expectedRoutes);

        // Act
        List<Route> result = routeRepository.findByDistanceInKm(9.5f);

        // Assert
        assertEquals(expectedRoutes,result);
        verify(routeRepository).findByDistanceInKm(9.5f);
    }

    @Test
    @DisplayName("test findRoutesByViaRoute: returns matching routes for instance containing parameter")
    void findRoutesByViaRoute_matches_on_via_points() {
        // Arrange
        List<Route> expectedRoutes = List.of(testRoute2, testRoute3);
        when(routeRepository.findRoutesByViaRoute("Blackfriars")).thenReturn(expectedRoutes);
        
        // Act
        List<Route> result = routeRepository.findRoutesByViaRoute("Blackfriars");

        // Assert
        // testRoute2 and testRoute3 has "Blackfriars Bridge" 
        assertEquals(2, result.size());
        assertTrue(result.containsAll(List.of(testRoute2, testRoute3)));
    }

}
