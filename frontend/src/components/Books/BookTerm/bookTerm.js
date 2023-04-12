import React from "react";
import {Link} from "react-router-dom";

const bookTerm = (props) => {
    return (
        <tr>
            <td scope={"col"}>{props.book.name}</td>
            <td scope={"col"}>{props.book.category}</td>
            <td scope={"col"}>{props.book.author.name}</td>
            <td scope={"col"}>{props.book.availableCopies}</td>
            <td scope={"col"} className={"text-right"}>
                <a title={"Delete"} className={"btn btn-danger"}
                   onClick={() => props.onDelete(props.book.id)}>
                    Delete
                </a>
                <Link className={"btn btn-info ml-2"}
                      onClick={() => props.onEdit(props.book.id)}
                      to={`/books/edit/${props.book.id}`}>
                    Edit
                </Link>
                <a className={"btn btn-secondary ml-2"}
                   onClick={() => props.onMark(props.book.id)}>Mark As Taken</a>
            </td>
        </tr>
    )
}

export default bookTerm;
