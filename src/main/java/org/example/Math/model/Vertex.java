package org.example.Math.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Vertex {
    protected boolean isVisited=false;
    protected int distanceToStart=Integer.MAX_VALUE;
}
