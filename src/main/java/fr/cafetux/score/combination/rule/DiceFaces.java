package fr.cafetux.score.combination.rule;

import fr.cafetux.score.dice.DiceFace;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toSet;

/**
 */
public class DiceFaces {

    private List<DiceFace> faces;

    public DiceFaces(List<DiceFace> faces) {
        this.faces = faces;
    }


    public DiceFaces distinct() {
        return new DiceFaces(new ArrayList<>(faces.stream()
                .collect(toSet())));
    }

    public DiceFaces filter(Predicate<DiceFace> predicate){
        return new DiceFaces(faces.stream().filter(predicate).collect(Collectors.toList()));
    }
    public Long count(DiceFace faceToCount) {
        return faces.stream().filter(f->f.hasSameIDentity(faceToCount)).count();
    }

    public void forEach(Consumer<DiceFace> consumer) {
        faces.forEach(consumer);
    }

    public List<DiceFace> toList() {
        return faces.stream().collect(Collectors.toList());
    }
}
