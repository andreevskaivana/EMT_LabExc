import axios from "../custom-axios/axios"
const LibraryService = {
    fetchAuthors: () => {
        return axios.get("/authors");
    },
    fetchBooks: () => {
        return axios.get("/books");
    },

    fetchCountries: () => {
        return axios.get("/countries");
    },
    fetchCategories: () => {
        return axios.get("/categories");
    },

    deleteBook: (id) => {
        return axios.delete(`/books/delete/${id}`)
    },

    addBook: (name, bookCategory, authorId, availableCopies) => {
        return axios.post("/books/add", {
            "name": name,
            "bookCategory": bookCategory,
            "authorId": authorId,
            "availableCopies": availableCopies,
        });
    },
    editBook: (id, name, bookCategory, authorId, availableCopies) => {
        return axios.put(`/books/edit/${id}`, {
            "name": name,
            "bookCategory": bookCategory,
            "authorId": authorId,
            "availableCopies": availableCopies,
        })
    },
    getBook: (id) => {
        return axios.get(`/books/${id}`);
    },
    markBook: (id) =>{
        return axios.put(`/books/mark/${id}`);
    }
}

export default LibraryService;