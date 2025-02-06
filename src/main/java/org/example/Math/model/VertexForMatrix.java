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
public class VertexForMatrix extends Vertex{
    private List<PairCoordinate> indexesOfNeighbourVertex=new ArrayList<>();
}
