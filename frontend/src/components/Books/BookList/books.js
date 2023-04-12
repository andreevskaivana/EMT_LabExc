import React from "react";
import ReactPaginate from "react-paginate";
import BookTerm from "../BookTerm/bookTerm";
import {Link} from "react-router-dom";


class Books extends React.Component {

    constructor(props) {
        super(props);

        this.state={
            page:0,
            size:5
        }
    }
    render() {
        const offset = this.state.size * this.state.page;
        const nextPageOffset = offset + this.state.size;
        const pageCount = Math.ceil(this.props.books.length / this.state.size);
        const books = this.getBooksPage(offset, nextPageOffset);

        return (
            <div>
                <div className={"container mm-4 mt-5"}>
                    <div className={"row"}>
                        <div className={"row"}>
                            <table className={"table table-stripped"}>
                                <thead>
                                <tr>
                                    <th scope={"col"}>Name</th>
                                    <th scope={"col"}>Book Category</th>
                                    <th scope={"col"}>Author ID</th>
                                    <th scope={"col"}>Available Copies</th>
                                </tr>
                                </thead>
                                <tbody>
                                {books}
                                </tbody>
                            </table>
                        </div>
                    </div>


                    <div className="col mb-3">
                        <div className="row">
                            <div className="col-sm-12 cold-md-12">
                                <Link className="btn btn-block btn-dark" to={"/books/add"}>Add New Book</Link>
                            </div>
                        </div>
                    </div>
                </div>
                <ReactPaginate
                    previousLabel={"BACK"}
                    nextLabel={"NEXT"}
                    breakLabel={<a href="/#">...</a>}
                    breakClassName={"break-me"}
                    pageClassName={"mx-2"} // Add horizontal margin to each page number
                    pageCount={pageCount}
                    marginPagesDisplayed={2}
                    pageRangeDisplayed={5}
                    onPageChange={this.handlePageClick}
                    containerClassName={"pagination m-4 justify-content-center"}
                    activeClassName={"active"}
                />

            </div>
        )
    }

    handlePageClick = (data) => {
        let selected=data.selected;
        this.setState({
            page:selected
        })
    }
    getBooksPage = (offset, nextPageOffset) => {
        return this.props.books.map((book, index) => {
            return (
                <BookTerm book={book} onDelete={this.props.onDelete} onEdit={this.props.onEdit} onMark={this.props.onMark}/>
            );
        }).filter((product, index) => {
            return index >= offset && index < nextPageOffset;
        })
    }

}

export default Books;