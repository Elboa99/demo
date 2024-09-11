package Services;

import entities.Autore;
import exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class AutoreService {

    private final List<Autore> autori = new ArrayList<>();

    public Autore save(Autore autore) {
        Random rndm = new Random();
        autore.setId(rndm.nextInt());
        autore.setAvatar("https://ui-avatars.com/api/?name=" + autore.getNome() + "+" + autore.getCognome());
        this.autori.add(autore);
        return autore;
    }

    public List<Autore> getAutori() {
        return this.autori;
    }

    public Autore findById(int id) {
        Autore found = null;

        for (Autore autore : autori) {
            if (autore.getId() == id)
                found = autore;
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }

    public void findByIdAndDelete(int id) {
        ListIterator<Autore> iterator = this.autori.listIterator();

        while (iterator.hasNext()) {
            Autore currentAutore = iterator.next();
            if (currentAutore.getId() == id) {
                iterator.remove();
            }
        }
    }

    public Autore findByIdAndUpdate(int id, Autore autore) {
        Autore found = null;

        for (Autore currentAutore : autori) {
            if (currentAutore.getId() == id) {
                found = currentAutore;
                found.setNome(autore.getNome());
                found.setCognome(autore.getCognome());
                found.setId(id);
            }
        }
        if (found == null)
            throw new NotFoundException(id);
        return found;
    }
}
