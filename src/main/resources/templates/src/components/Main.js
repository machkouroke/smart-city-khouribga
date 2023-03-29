import '../style/scss/styles.scss';
import {LeftSidebar} from "./LeftSidebar";
import {CreatePost} from "./CreatePost";
import {UserPost} from "./UserPost";
import {RightSideBar} from "./RightSideBar";

export function Main() {
    return (
        <div className="container">
            <div className="row">
                <LeftSidebar />
                <div className="col-lg-6 col-12 timeline">
                    <CreatePost />
                    {/* Boucle sur les posts */}
                    <UserPost />

                </div>
                <RightSideBar />
            </div>
        </div>)
}