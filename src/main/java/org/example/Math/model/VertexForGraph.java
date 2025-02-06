package org.example.Math.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VertexForGraph extends Vertex{
    private List<Integer> indexesOfNeighbourVertex=new ArrayList<>();
}
