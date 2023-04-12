import React from "react";
import {useHistory} from "react-router-dom";

const BookEdit = (props) => {

    const history = useHistory();
    const [formData, updateFormData] = React.useState({
        name: "",
        bookCategory: "",
        authorId: 0,
        availableCopies: 0,
    });

    const handleChange = (e) => {
        updateFormData({
            ...formData,
            [e.target.name]: e.target.value.trim(),
        });
    };

    const onFormSubmit = (e) => {
        e.preventDefault();
        const name = formData.name!== "" ? formData.name : props.book.name;
        const bookCategory = formData.bookCategory;
        const authorId = formData.authorId!== 0 ? formData.authorId : props.book.authorId;;
        const availableCopies = formData.availableCopies !== 0 ? formData.availableCopies : props.book.availableCopies;
        props.onEditBook(props.book.id,name, bookCategory, authorId, availableCopies);
        history.push("/books");
    };

    return (
        <div className="row mt-5">
            <div className="col-md-5">
                <form onSubmit={onFormSubmit}>
                    <div className="form-group">
                        <label htmlFor="name">Book name</label>
                        <input
                            type="text"
                            className="form-control"
                            id="name"
                            name="name"
                            required
                            placeholder={props.book.name}
                            onChange={handleChange}
                        />
                    </div>
                    <div className="form-group">
                        <label>Book Category</label>
                        <select name="bookCategory" className="form-control" onChange={handleChange}>
                            {props.categories.map((book) =>
                                <option value={book}>{book}</option>
                            )}
                        </select>
                    </div>
                    <div className="form-group">
                        <label>Author</label>
                        <select
                            name="authorId"
                            id="authorId"
                            className="form-control"
                            onChange={handleChange}
                        >
                            {props.authors.map((author) => (
                                <option key={author.id} value={author.id}>
                                    {author.name}
                                </option>
                            ))}
                        </select>
                    </div>
                    <div className="form-group">
                        <label htmlFor="quantity">Available Copies</label>
                        <input type="text"
                               className="form-control"
                               id="availableCopies"
                               name="availableCopies"
                               placeholder={props.book.availableCopies}
                               onChange={handleChange}
                        />
                    </div>
                    <button id="submit" type="submit" className="btn btn-primary">
                        Submit
                    </button>
                </form>
            </div>
        </div>
    );

}
export default BookEdit;