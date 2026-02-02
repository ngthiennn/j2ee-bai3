package com.example.bai2.services;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.bai2.models.Category;
import com.example.bai2.models.Product;

@Service
public class CategoryService {

    private List<Category> categories = new ArrayList<>();

    public CategoryService() {
        categories.add(new Category(1, "Điện thoại"));
        categories.add(new Category(2, "Laptop"));
    }

    public List<Category> getAll() {
        return categories;
    }

    public Category get(int id) {
        return categories.stream()
                .filter(c -> c.getId() == id)
                .findFirst()
                .orElse(null);
    }
}
