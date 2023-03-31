import style from "../style/scss/tailwind.module.scss"
import PropTypes from 'prop-types';

export function UserPost(props) {
    const offer =
       props.offer

    return (
        <div>
            <div className="post card">
                <div className="d-flex user">
                    <img
                        className="rounded-circle"
                        src={offer.picture}
                        alt="profile picture"
                    />
                    <div>
                        <h6 className="text-center">{offer.title}</h6>
                        <span className="text-center">{offer.type}</span>

                    </div>
                    <a href="templates/src/components#">
                        <i className="fas fa-ellipsis-h"></i>
                    </a>
                </div>

                <p>

                    <i className="fa fa-clock m-3"></i> {offer.postedAt}<br/>
                    <i className="fa fa-location-arrow m-3"></i> {offer.location}<br/>
                    <i className="fa fa-briefcase m-3"></i> {offer.domain}<br/>
                    <i className="fa fa-envelope m-3"></i> <a
                    href={`mailto:${offer.contact}`}>{offer.contact}</a><br/>
                    <p className="black mx-3">
                        {offer.description}
                    </p>


                </p>
                <div className={"d-flex"}>
                    {
                        offer.tag.map((tag) =>
                            <div
                                className="inline-block bg-gray-200 rounded-full px-3 mx-2 py-1 text-sm font-semibold text-gray-700 mr-2">
                                #{tag}
                            </div>)
                    }

                </div>


                {/*Post Actions */}
                <div className="d-flex post-actions">
                    <button className="w-100 text-center"><i className="fa fa-briefcase "></i>Postuler</button>

                    <button className="w-100 text-center"><i className="far fa-thumbs-up"></i>120k Likes
                    </button>
                </div>
            </div>
            {/*Post User*/}


        </div>
    )
}

UserPost.propTypes = {
    offer: PropTypes.object.isRequired
}