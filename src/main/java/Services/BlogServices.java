package Services;

import entities.Blog;
import exceptions.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

@Service
public class BlogServices {

    private final List<Blog> blogList = new ArrayList<>();

    public Blog save(Blog blog) {
        Random rdm = new Random();
        blog.setId(rdm.nextInt());
        blog.setCover("https://picsum.photos/200/300");
        this.blogList.add(blog);
        return blog;
    }

    public List<Blog> getBlogList() {
        return this.blogList;
    }

    public Blog findById(int blogId) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == blogId) {
                found = blog;
            }
        }
        if (found == null) {
            throw new NotFoundException(blogId);
        }
        return found;
    }

    public void findByIdAndDelete(int blogId) {
        ListIterator<Blog> iterator = this.blogList.listIterator();
        while (iterator.hasNext()) {
            Blog currentBlog = iterator.next();
            if (currentBlog.getId() == blogId) {
                iterator.remove();
            }
        }
    }

    public Blog findByIdAndUpdate(int blogId, Blog updateBlog) {
        Blog found = null;
        for (Blog blog : this.blogList) {
            if (blog.getId() == blogId) {
                found = blog;
                found.setTitolo(updateBlog.getTitolo());
                found.setCategoria(updateBlog.getCategoria());
                found.setContenuto(updateBlog.getContenuto());
                found.setCover(updateBlog.getCover());
                found.setTempo_lettura_min(updateBlog.getTempo_lettura_min());
            }
        }
        if (found == null) {
            throw new NotFoundException(blogId);
        }
        return found;
    }
}
