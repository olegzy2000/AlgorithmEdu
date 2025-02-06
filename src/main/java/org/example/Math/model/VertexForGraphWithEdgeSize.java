package org.example.Math.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VertexForGraphWithEdgeSize extends Vertex{
    private List<PairVertexAndEdgeSize> listPairNumberOfVertexAndSizeOfEdge=new ArrayList<>();

    @Override
    public int getDistanceToStart() {
        return super.getDistanceToStart();
    }
}
